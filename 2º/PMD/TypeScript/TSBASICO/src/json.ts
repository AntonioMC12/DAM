import * as data from "../data/mock.json";

for (let key in data) {
    console.log(key);
    let persona = (<any>data)[key];
    console.log(persona.name);
    console.log("----------------");
}