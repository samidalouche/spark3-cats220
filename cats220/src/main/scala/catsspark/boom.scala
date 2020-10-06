package catsspark

import cats._
import cats.data._
import cats.syntax.all._

object Boom {
  def boom() = {
    val validated = 1
      .valid[String]
      .ensure("should be [0-inf[")(_ >= 0)
      .toValidatedNel

    println(Boom.assumeValid_!(validated))
  }

  def assumeValid_![E: Show, A](
      validatedNel: Validated[NonEmptyList[E], A]
  ): A = doAssumeValid_!(validatedNel)

  def doAssumeValid_![E: Show, A, F[_, _]: Bifoldable](
      validated: F[E, A]
  ): A = {
    val res = validated.bifoldLeft(none[A])(
      (_, error: E) => throw new IllegalArgumentException(error.show),
      (_, v) => v.some
    )
    res.get // safe since an exception would already have been thrown if no result
  }
}
