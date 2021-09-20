class Greeter {
    private greeting: string;

    constructor(message: string) {
        this.greeting = message;
    }

    public greet(): string {
        return "Hello" + this.greeting;
    }
}

let greeter = new Greeter("Antonio");
let button = document.createElement("button");
button.textContent = "Say Hello";
button.onclick = () => { alert(greeter.greet()); }
document.body.appendChild(button);
