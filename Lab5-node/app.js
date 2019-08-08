const os = require('os'),
    fs = require('fs');

console.log('Architecture ' + os.arch());
console.log('CPUs ' + os.cpus().length);
console.log('OS ' + os.platform());
console.log(os.EOL);

const fileName = __dirname + "/test.txt";

//method 1 - async
fs.readFile(fileName, (err, data) => {
    if (err) {
        console.error(err);
    }
    console.log(data.toString());
});

//method 2 - sync
const data = fs.readFileSync(fileName).toString();
console.log(data);
