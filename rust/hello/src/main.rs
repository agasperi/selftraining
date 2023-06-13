use random::Source;

fn main() {
    let mut source = random::default(42);
    let num = source.read::<i32>();
    println!("The number is: {}", num);
}
