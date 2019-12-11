var fs = require('fs');
fs.writeFileSync("food.txt","나는 감자가 좋아요");

console.log(fs.readFileSync("food.txt").toString());