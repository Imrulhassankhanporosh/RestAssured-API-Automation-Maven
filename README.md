# RestAssured-API-Automation-Maven
My Rest assured project using maven for api automation. 

Features :

1. API testing for GET, POST, PUT and DELETE Method.

2. Request Data has been added to request by :
   1. Using Data Provider annotation.
   2. Reading data frm Excel File.
  
3. Writing the data fetched from response, in an Excel file using a test case method.

4. Used a json local server to create some api and used a db.jsoin file to test the api request data and its functionalities(GET, POST, PUT and DELETE Method).



# json-server-local-api
This is to create some api in the local server



1. DownLoad node.js
link : https://nodejs.org/en/download/
2. Open cmd and run below command
-->> npm install -g json-server
3. Again run below command
-->>json-server --watch db.json
4. Now go to the file location where you have ran the step 3 command and search for db.json file
5. Right click on the db.json file and choose option "Edit with Nodepad++"
6. Clear all the data of the file and copy+paste the below content
-->>
{
  "users": [
    {
      "firstName": "tamanna",
      "lastName": "tuly",
      "subjectId": "1",
	  "id": "1"
    },
	{
      "firstName": "ria",
      "lastName": "khan",
      "subjectId": "2",
	  "id": "2"
    },
	{
      "firstName": "morium",
      "lastName": "meher",
      "subjectId": "1",
	  "id": "3"
    }
  ],
  "subjects": [
    {
      "id": 1,
      "name": "Automation"
    },
	{
      "id": 2,
      "name": "Manual"
    }
  ]
}

7. save the file and go to http://localhost:3000/ from your browser
