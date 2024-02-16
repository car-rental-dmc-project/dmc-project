const config = require('config');
const mysql = require('mysql2');
const express = require('express');
const app = express.Router();



const connectionDetails = {
                            host : config.get("server"),
                            database : config.get("database"),
                            user : config.get("user"),
                            password : config.get("password")
                            }

app.get('/', (request, response) => {
    var statement = `select * from users`;
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


app.post('/', (request, response) => {

    var first_name = request.body.first_name;
    var middle_name = request.body.middle_name;
    var last_name = request.body.last_name;
    var contact = request.body.contact;
    var email = request.body.email;
    var password = request.body.password;
    var dob = request.body.dob;
    var gender = request.body.gender;


    var statement = `Insert into users(first_name, middle_name, last_name, contact, email, password, dob, gender) 
                        values('${first_name}','${middle_name}','${last_name}','${contact}','${email}','${password}','${dob}','${gender}')`;

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

app.put('/:user_id', (request, response) => {

    var driving_license = request.body.driving_license;
    var first_name = request.body.first_name;
    var middle_name = request.body.middle_name;
    var last_name = request.body.last_name;
    var contact = request.body.contact;
    var email = request.body.email;
    var aadhar_no = request.body.aadhar_no;
    var pan_no = request.body.pan_no;
    var dob = request.body.dob;


    var statement = `update users set 
                     first_name = '${first_name}',
                     middle_name = '${middle_name}',  
                     last_name = '${last_name}', 
                     contact = '${contact}', 
                     email = '${email}', 
                     aadhar_no = '${aadhar_no}', 
                     pan_no = '${pan_no}', 
                     dob = '${dob}' 
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