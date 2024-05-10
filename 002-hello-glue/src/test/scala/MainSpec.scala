import org.scalatest._ 

class HelloJobSpec extends FunSpec {
    describe("main") {
        it("should run the job") {
            println(s"Starting ExampleJob at ${new java.util.Date()}")

            chapter002.HelloJob.main(Array(
              "--JOB_NAME", "job",
              "--stage", "dev",
              "--inputBucket", "<YOUR BUCKET NAME>",
              "--outputBucket", "<YOUR OUTPUT BUCKET NAME>",
              "--inputPrefix", "<YOUR INPUT PREFIX>",
              "--outputPrefix", "<YOUR OUTPUT PREFIX>"
            ))

            println(s"ExampleJob Finished at ${new java.util.Date()}")
        }
    }
}