package fiot

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.*
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.*
import kotlin.reflect.jvm.isAccessible


fun tst1(){

//    Files.write()
//    Files.createFile("a.json" , )

//    var f:File = File("/Users/gimcheol-u/Documents/work/Personal/KotlinExam/test/src/main/kotlin"
//        , "/Users/gimcheol-u/Documents/work/Personal/KotlinExam/test/src/main/kotlin/a.json")

    var f:File = File("xferlog.txt")
//
    if(!f.exists()){
        println("create")
//        f.createNewFile()

//        f.createNewFile()

        var os: BufferedOutputStream = BufferedOutputStream(FileOutputStream(f))
        os.write("aaaaaaaaa".toByteArray())
        os.close()

//        os.writer("akfakfalkjflajkflajfla" , adfafaaa)
    }else{
        println("exist")
        f.delete()
    }

}



fun tst2(){
    data class User constructor(var name:String? , var age:Int?)

    fun convertJson(obj: Any , arg: KClass<*>):JSONObject{
        val jObj:JSONObject = JSONObject()
        arg.declaredMemberProperties.forEach {
            jObj[ it.name ] = it.getter.call(obj) as Any
        }
        return jObj
    }

    fun jsonWrite(arg:JSONObject){
        val f:File = File("data.json")
        val bos:BufferedOutputStream = BufferedOutputStream(FileOutputStream(f, f.exists()))
        bos.write(arg.toJSONString().toByteArray())
        bos.write("\n".toByteArray())
        bos.close()
    }


    fun jsonRead(arg:KClass<*>){
        val f:File = File("data.json")
        if(!f.exists()){
            println("파일이 존재하지 않습니다.")
            throw Throwable("file not found")
        }

        val bis:BufferedInputStream = BufferedInputStream(FileInputStream(f))
        var br: BufferedReader = BufferedReader(InputStreamReader(bis , StandardCharsets.UTF_8))
        var parser: JSONParser =  JSONParser()
        var line:String? = null

        var resultList: MutableList<User> = mutableListOf()
        while(true){
            line = br.readLine()
            if(line == null)break
            var jObj:JSONObject = parser.parse(line) as JSONObject
            val nAge: Int by lazy {
                if(jObj.get("age") is Long){
                    (jObj.get("age") as Long).toInt()
                }else{
                    jObj.get("age") as Int
                }
            }

            var u = User(jObj.getOrDefault("name" , "") as String
            ,nAge)
            resultList.add(u)
        }
        br.close()
        resultList.forEach { println(it.toString()) }
    }


//    var ini : KClass<*> = User::class
//    ini.declaredMemberProperties.forEach {
//
//    }

    val inpuFunc:(text:String)->Any = {t->
        println(t)
        var inscanner = Scanner(System.`in`)
        if(t.contains("name"))inscanner.next()
        else inscanner.nextInt()
    }

    while(true){
        println("==========================================")
        println("1.new")
        println("2.display")
        println("3.quit")
        println("==========================================")
        var scanner = Scanner(System.`in`)
        var inputNum = scanner.nextInt()

        when(inputNum){
            1-> {
                val name = inpuFunc("input name") as String
                val age: Int = inpuFunc("input age") as Int
                val m: JSONObject = convertJson(User(name , age) , User::class)
                jsonWrite(m)
            }
            2-> jsonRead(User::class)
            3-> break
        }

    }

    println("End")


}




fun main(){
//    tst1()

    tst2()
}