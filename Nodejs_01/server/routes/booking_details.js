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

app.get('/booking', (request, response) => {
    var statement = `select bd.booking_id, bd.from_datetime, bd.to_datetime, bd.amount_per_hour, bd.status, bd.discount, bd.deposit, cd.model_name as car_model, cd.cost_per_hour as car_cost_per_hour from booking_details bd join car_details cd on bd.car_id = cd.car_id; `;
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

    var statement = `Insert into booking_details(from_datetime, to_datetime, amount_per_hour, status, discount, deposit, car_id) 
                        values('${from_datetime}','${to_datetime}','${amount_per_hour}','${status}','${discount}','${deposit}', '${car_id}')`;

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
