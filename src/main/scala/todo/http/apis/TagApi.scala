/*
 * Copyright 2017-2018 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package todo
package http
package apis

import cats.~>
import cats.instances.list._
import cats.syntax.traverse._
import com.twitter.util.Future
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._
import freestyle.free._
import freestyle.free.http.finch._
import freestyle.free.logging._
import todo.model.Tag
import todo.services._
import todo.model.Tag

class TagApi[F[_]](implicit service: TagService[F], handler: F ~> Future) extends CRUDApi[Tag] {

  import io.finch.syntax._

  val reset = post(service.prefix :: "reset") {
    service.reset.map(Ok)
  }

  val retrieve = get(service.prefix :: path[Int]) { id: Int =>
    service.retrieve(id) map (item =>
      item.fold[Output[Tag]](
        NotFound(new NoSuchElementException(s"Could not find ${service.model} with $id")))(Ok))
  } handle {
    case nse: NoSuchElementException => NotFound(nse)
  }

  val list = get(service.prefix) {
    service.list.map(Ok)
  }

  val insert = post(service.prefix :: jsonBody[Tag]) { item: Tag =>
    service.insert(item).map(Ok)
  }

  val update = put(service.prefix :: path[Int] :: jsonBody[Tag]) { (id: Int, item: Tag) =>
    service.update(item.copy(id = Some(id))).map(Ok)
  }

  val destroy = delete(service.prefix :: path[Int]) { id: Int =>
    service.destroy(id).map(Ok)
  } handle {
    case nse: NoSuchElementException => NotFound(nse)
  }
}

object TagApi {
  implicit def instance[F[_]](implicit service: TagService[F], handler: F ~> Future): TagApi[F] =
    new TagApi[F]
}
