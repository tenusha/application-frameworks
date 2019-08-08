const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});

    switch (req.method) {
        case 'GET':
            res.write('<h1>Hello World!!!</h1>');
            res.end();
            break;
        case 'POST':
            req.on('data', (data) => {
                res.write('<h1>' + data + '</h1>');
                res.end();
            });
            break;
    }
});

server.listen(3000, data => console.log("Listning port 3000"));

server.on('clientError', (err, socket) => {
    console.log(err);
    socket.end('400 Bad Request');
});