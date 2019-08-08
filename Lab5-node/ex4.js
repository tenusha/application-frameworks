const fs = require('fs'),
    util = require('util');

const fileName = __dirname + "/test.txt";
const outFileName = __dirname + "/test-copy.txt";

const readStream = fs.createReadStream(fileName);
const writeStream = fs.createWriteStream(outFileName);

readStream.pipe(writeStream);

readStream.on('data', (data) => {
    console.log(data.toString());
});

readStream.on('error', (err) => {
    console.log(err.toString());
});

// readStream.on('end',()=>{
//     console.log("end of read stream");
// });