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
    var statement = `select * from car_details`;
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

app.get('/cardetails', (request, response) => {
    var statement = `select cd.model_name, cd.cost_per_hour, cd.transmission, cd.no_of_seats, cd.availability, l.city from car_details cd join location l on cd.location_id = l.location_id;`;
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
   
    var model_name = request.body.model_name;
    var purchase_year = request.body.purchase_year;
    var availability = request.body.availability;
    var location_id = request.body.location_id;
    var no_of_seats = request.body.no_of_seats;
    var luggage_capacity = request.body.luggage_capacity;
    var cost_per_hour = request.body.cost_per_hour;
    var late_fee_per_hour = request.body.late_fee_per_hour;
    var fuel_type = request.body.fuel_type;
    var kms_driven = request.body.kms_driven;
    var transmission = request.body.transmission;
    var mileage = request.body.mileage;
    var car_color = request.body.car_color;
    var user_id = request.body.user_id;
    var insurance = request.body.insurance;
    var description = request.body.description;


    var statement = `Insert into car_details(model_name, purchase_year, availability, location_id, no_of_seats, luggage_capacity, cost_per_hour, late_fee_per_hour, fuel_type, kms_driven, transmission, mileage, car_color, user_id, insurance, description) 
                        values('${model_name}','${purchase_year}','${availability}','${location_id}','${no_of_seats}','${luggage_capacity}','${cost_per_hour}','${late_fee_per_hour}','${fuel_type}','${kms_driven}','${transmission}','${mileage}','${car_color}','${user_id}','${insurance}','${description}')`;

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

app.delete('/:car_id', (request, response) => {

    var car_id = request.params.car_id;

    var statement = `delete from car_details where car_id='${car_id}'`;

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

app.put('/:car_id', (request, response) => {
    
    var availability = request.body.availability;
    var cost_per_hour = request.body.cost_per_hour;
    var late_fee_per_hour = request.body.late_fee_per_hour;
    var kms_driven = request.body.kms_driven;
    var car_color = request.body.car_color;
    var insurance = request.body.insurance;
    var description = request.body.description;

    var statement = `update car_details set 
                     availability = '${availability}',
                     cost_per_hour = '${cost_per_hour}',
                     late_fee_per_hour = '${late_fee_per_hour}',
                     kms_driven = '${kms_driven}',
                     car_color = '${car_color}',
                     insurance = '${insurance}',
                     description = '${description}'
                     where car_id = '${request.params.car_id}'`;

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