//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/split-house-547be0e9/

fun main(args: Array<String>){
    val testCases = readLine()
    val path = readLine()
    val pathWithBoundaries = AddBoundaries(path)

    val output = IsPossible(pathWithBoundaries)
        if(output){
            println("YES")
            println(pathWithBoundaries)
        }
        else{
            println("NO")
        }

}

fun AddBoundaries(path: String?): String{
    return path!!.replace(".","B")
}

fun IsPossible(sut: String?) : Boolean{
        for((index,value) in sut!!.withIndex()){
            if(value == 'H'){
                if(index + 1 < sut.length){
                    if(sut[index+1] == 'H') {
                        return false
                    }
                }
            }
        }
    return true
}
