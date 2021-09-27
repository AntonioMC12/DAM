"use strict";
exports.__esModule = true;
var data = require("../data/mock.json");
for (var key in data) {
    console.log(key);
    console.log(data[key]);
    console.log("----------------");
}
