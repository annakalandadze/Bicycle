# Bicycle

## About assignment: 
Creating the bicycle with a gear. 
The assignment was done in Java using Spring. The assignment includes only backend part - thus should be tested through Postman. The intructions will follow.

## Getting started

### Classes
I deicded to divide Bicycle and Gear into separate classes. This decision was made due to complexity of gear: it has many attributes and class which extend it. 
Expensive and cheap gears extend Gear class. Bicycle and Gear are connected: Bicycle has its own gear.

### Database
For tis assignment I used simple H2 database. This is default for Spring and a good choice for the task: it doesn't need complicated structure. Bicycle and Gear are connected in 
the database: bicycle points to gear by gear.id.


## Further on functionalities

### 1. Create Bicycle
We can create bicycle with either expensive or cheap gear. For this we need an RequestObject - in our case it will contain both gear and bicycle (JSON).
If we test it in postman, we parse data \
```json
{
    "frontWheelSize": 30,
    "rearWheelSize": 31,
    "gear": {
        "chainTeeth": 4,
        "gearLevel": 32,
        "sprocketTeeth": 10,
        "gearRatio": 0.0,
        "id": 1
    }
} 
```
in such format. The result is 200OK if we parsed ecerything correctly.

### 2. Get Bicycle
Bike is searched by id and if exists - returns. In postman the result would be\
```json
{
    "frontWheelSize": 30, 
    "rearWheelSize": 31,
    "gear": {
        "chainTeeth": 4,
        "gearLevel": 32,
        "sprocketTeeth": 10,
        "gearRatio": 0.0,
        "id": 1
    }
}
```

### 3. Increment gear level
Increments gear level by one if gear exists.

### 4. Decrement gear level
Decrements gear level by one if gear exists.

## Details
To access a database follow http://localhost:8080/h2-console . The username is "sa", password - pass. For all other questions - contact me.
