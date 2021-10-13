# Welcome to the script

Write-Host "Welcome from Linux Academy!!!"

# Connect to Azure Account

Connect-AzAccount

# Get the date

$date = Get-Date
Write-Host "Today is " $date

# Get my name
$name = "Arnoldo Gásperi"
Write-Host "My name is " $name

# Get all azure Resources

Get-AzResource | Export-Csv -Path C:\Users\Usuario\Dropbox\training\Azure\test.csv

Get-AzResource | ConvertTo-Html | Out-File C:\Users\Usuario\Dropbox\training\Azure\test.html