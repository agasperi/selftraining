using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using System.Text;


namespace com.aega.training
{
    public static class WritingToBlobStorage
    {
        [FunctionName("WritingToBlobStorage")]
        public static async Task<IActionResult> Run(
            [HttpTrigger(AuthorizationLevel.Anonymous, "get", "post", Route = null)] HttpRequest req,
            [Blob("outputdemo/{sys.utcnow}.txt", FileAccess.Write, Connection = "AzureWebJobsStorage")] Stream outputFile,
            ILogger log)
        {
            log.LogInformation("C# HTTP trigger function processed a request.");

            string name = req.Query["name"];

            string requestBody = await new StreamReader(req.Body).ReadToEndAsync();
            dynamic data = JsonConvert.DeserializeObject(requestBody);
            name = name ?? data?.name;

            UnicodeEncoding uniencoding = new UnicodeEncoding();
            string messageToWriteToFile = "Message from " + name;
            byte[] output = uniencoding.GetBytes(messageToWriteToFile);
            await outputFile.WriteAsync(output,0,output.Length);

            var files = req.Form.Files;
            foreach (var file in files)
            {
                log.LogInformation("The file name is: " + file.FileName);
            }

            return new OkObjectResult("File uploaded to Azure Blob Storage!");
        }
    }
}
