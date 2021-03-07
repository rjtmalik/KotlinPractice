//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-factorial/

fun main(args: Array<String>){
    val number = readLine()!!.toInt()
    print(FactorialOf(number))
}

fun FactorialOf(number: Int): Int{
    var result = 1;
    for(e in 1 until number+1){
        result *= e
    }
    return result;
}
