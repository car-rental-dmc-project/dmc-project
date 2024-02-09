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
    var statement = `select * from booking_details`;
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

    var from_datetime = request.body.from_datetime;
    var to_datetime = request.body.to_datetime;
    var amount_per_hour = request.body.amount_per_hour;
    var status = request.body.status;
    var discount = request.body.discount;
    var deposit = request.body.deposit;
    var car_id = request.body.car_id;
    var pickup_drop = request.body.pickup_drop;

    var statement = `Insert into booking_details(from_datetime, to_datetime, amount_per_hour, status, discount, deposit, car_id, pickup_drop) 
                        values('${from_datetime}','${to_datetime}','${amount_per_hour}','${status}','${discount}','${deposit}', '${car_id}', '${pickup_drop}')`;

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


app.delete('/:booking_id', (request, response) => {

    var location_id = request.params.location_id;

    var booking_id = request.params.booking_id;

    var statement = `delete from booking_details where booking_id=${booking_id}`;

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


app.put('/:booking_id', (request, response) => {

    var from_datetime = request.body.from_datetime;
    var to_datetime = request.body.to_datetime;
    
    var statement = `update booking_details set 
                     from_datetime = '${from_datetime}',
                     to_datetime = '${to_datetime}'
                     where booking_id = '${request.params.booking_id}'`;

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
