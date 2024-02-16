const config = require('config');
const mysql = require('mysql');
const express = require('express');
const app = express.Router();



const connectionDetails = {
                            host : config.get("server"),
                            database : config.get("database"),
                            user : config.get("user"),
                            password : config.get("password")
                          }


//to get all users                        
app.get('/', (request, response) => {
    var statement = `select * from users`;
    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        console.log(result);
        console.log(error);
        if(error==null)
        {
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});



//to register a user 
app.post('/register', (request, response) => {

    // var driving_license = request.body.driving_license;
    var first_name = request.body.first_name;
    var middle_name = request.body.middle_name;
    var last_name = request.body.last_name;
    var contact = request.body.contact;
    var email = request.body.email;
    var password = request.body.password;
    // var dob = request.body.dob;
    // var gender = request.body.gender;
    // var aadhar_no = request.body.aadhar_no;
    // var pan_no = request.body.pan_no;
    // var status = request.body.status;


    var statement = `Insert into users(first_name, middle_name, last_name, contact, email, password) 
                        values('${first_name}','${middle_name}','${last_name}','${contact}','${email}','${password}')`;

    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        if(error==null)
        {
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});



//to delete a user  
app.delete('/:user_id', (request, response) => {

    var user_id = request.params.user_id;

    var statement = `delete from users where user_id=${user_id}`;

    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        if(error==null)
        {
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});


//to update user details
app.put('/:user_id', (request, response) => {

    var contact = request.body.contact;
    var email = request.body.email;
    var password = request.body.password;


    var statement = `update users set 
                     contact = '${contact}', 
                     email = '${email}', 
                     password = '${password}'
                     WHERE user_id = ${request.params.user_id}`;
                     
    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        if(error==null)
        {
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});

module.exports = app;