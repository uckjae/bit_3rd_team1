var fs = require('fs');

fs.writeFileSync("food.text","���� ���ڰ� ���ƿ� ����");

console.log(fs.readFileSync("food.txt").toString());