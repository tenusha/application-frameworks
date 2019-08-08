'use strict'
;
const express = require('express');
const app = express();

app.use(express.json());
app.use(express.static(__dirname + "/web"));

const users = [];

app.get('/', (req, res, next) => {
    res.sendFile('index.html');
});

/**
 {
"name":"Tenusha",
"age":24,
"birthDay":"1995-10-21"
}
 */
app.post('/users', (req, res, next) => {
    const body = req.body;
    const id = Date.now();
    const birthDay = new Date(body.birthDay);
    const user = {...body, id: id, birthDay: birthDay};
    users.push(user);
    res.status(201).json(user);
});

app.get('/users', (req, res, next) => {
    res.status(200).json(users);
});

app.get('/users/:id', (req, res, next) => {
    const id = req.params.id;
    const user = users.find(user => user.id === parseInt(id));
    res.status(200).json(user);
});

app.put('/users/:id', (req, res, next) => {
    const id = req.params.id;
    const index = users.findIndex(user => user.id === parseInt(id));
    if (index >= 0) {
        users[index] = {...users[index], ...req.body};
        res.status(200).json(users[index]);
    } else {
        res.status(404).json("user not found");
    }

});

app.delete('/users/:id', (req, res, next) => {
    const id = req.params.id;
    const index = users.findIndex(user => user.id === parseInt(id));
    if (index >= 0) {
        users.splice(index, 1);
        res.status(201).json("user " + id + " deleted");
    } else {
        res.status(404).json("user not found");
    }

});

app.listen(3000, err => {
    if (err) {
        console.error(err);
        return;
    }
    console.log('app listening on port 3000');
});