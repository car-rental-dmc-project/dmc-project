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


// join query to used to display location of car and customer
// using car_id in booking_details and location_id in car_details
app.get('/',(request, response) => {
    var car_id = request.body.car_id;
    var statement = `select * from booking_details where car_id = ${car_id}`;
    var connection = mysql.createConnection(connectionDetails);
    connection.query(statement,(error,result)=>{
        if(error==null){
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

app.post('/', (request, response) => {

    var from = request.body.from_datetime;
    var to = request.body.to_datetime;
    var amount_per_hour = request.body.amount_per_hour;
    var status = request.body.status;
    var discount = request.body.discount;
    var deposit = request.body.deposit;
    var car_id = request.body.car_id;

    var statement = `insert into booking_details(from_datetime,to_datetime,amount_per_hour,status,discount,deposit,car_id) values('${from}','${to}',${amount_per_hour},${status},${discount},${deposit},${car_id})`;

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
