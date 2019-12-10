var fs = require('fs');

fs.writeFileSync("food.text","나는 감자가 좋아요 ㅎㅎ");

console.log(fs.readFileSync("food.txt").toString());