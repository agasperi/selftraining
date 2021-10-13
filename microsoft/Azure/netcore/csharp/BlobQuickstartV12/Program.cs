using Azure.Storage.Blobs;
using Azure.Storage.Blobs.Models;
using System;
using System.IO;
using System.Threading.Tasks;


namespace BlobQuickstartV12
{
    class Program
    {
        static async Task Main()
        {
            // Step 1. Connecting and building container
            Console.WriteLine("Azure Blob Storage v12 - .NET quickstart sample\n");

            string connectionString = Environment.GetEnvironmentVariable("AZURE_STORAGE_CONNECTION_STRING");

            BlobServiceClient blobServiceClient = new BlobServiceClient(connectionString);
            string containerName = "quickstartblobs" + Guid.NewGuid().ToString();

            BlobContainerClient containerClient = await blobServiceClient.CreateBlobContainerAsync(containerName);

            // Step 2. Uploading and listing file
            string localPath = "./data/";
            string fileName = "quickstart" + Guid.NewGuid().ToString() + ".txt";
            string localFilePath = Path.Combine(localPath, fileName);

            await File.WriteAllTextAsync(localFilePath, "Hello, World!");

            BlobClient blobClient = containerClient.GetBlobClient(fileName);

            Console.WriteLine("Uploading to Blob storage as blob:\n\t {0}\n", blobClient.Uri);

            await blobClient.UploadAsync(localFilePath,true);

            Console.WriteLine("Listing blobs...");

            await foreach (BlobItem blobItem in containerClient.GetBlobsAsync())
            {
                Console.WriteLine("\t" + blobItem.Name);
            }

            // Step 3. Downloading file
            string downloadFilePath =  localFilePath.Replace(".txt", "DOWNLOADED.txt");

            Console.WriteLine("\nDownloading blog to\n\t{0}\n", downloadFilePath);

            await blobClient.DownloadToAsync(downloadFilePath);

            // Step 4. Cleaning
            Console.Write("Press any key to begin clean up");
            Console.ReadLine();

            Console.WriteLine("Deleting blob container...");
            await containerClient.DeleteAsync();

            Console.WriteLine("Deleting the local source and downloaded files...");
            File.Delete(localFilePath);
            File.Delete(downloadFilePath);

            Console.WriteLine("Done!");
        }
    }
}
