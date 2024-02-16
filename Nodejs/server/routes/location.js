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

app.get('/', (request, response) => {
    var statement = `select * from location`;
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

    var street = request.body.street;
    var landmark = request.body.landmark;
    var city = request.body.city;
    var state = request.body.state;
    var zip_code = request.body.zip_code;
    var user_id = request.body.user_id;

    var statement = `Insert into location(street, landmark, city, state, zip_code, user_id) 
                        values('${street}','${landmark}','${city}','${state}','${zip_code}','${user_id}')`;

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

app.delete('/:location_id', (request, response) => {

    var location_id = request.params.location_id;

    var statement = `delete from location where location_id=${location_id}`;

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

app.put('/:location_id', (request, response) => {

    var street = request.body.street;
    var landmark = request.body.landmark;
    var city = request.body.city;
    var state = request.body.state;
    var zip_code = request.body.zip_code;
    var user_id = request.body.user_id;


    var statement = `update location set 
                     street = '${street}',
                     landmark = '${landmark}',  
                     city = '${city}', 
                     state = '${state}', 
                     zip_code = '${zip_code}', 
                     user_id = '${user_id}'
                     WHERE location_id = ${request.params.location_id}`;
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