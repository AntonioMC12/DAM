"use strict";
class Greeter {
    constructor(message) {
        this.greeting = message;
    }
    greet() {
        return "Hello" + this.greeting;
    }
}
let greeter = new Greeter("Antonio");
let button = document.createElement("button");
button.textContent = "Say Hello";
button.onclick = () => { alert(greeter.greet()); };
document.body.appendChild(button);
