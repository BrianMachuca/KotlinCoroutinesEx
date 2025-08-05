// Defino la habilidad de volar. Cualquier clase que la implemente
// DEBE proporcionar una función fly().
interface Flyable {
    fun fly()
}

// Defino la habilidad de caminar.
interface Walkable {
    fun walk()
}

// Defino la habilidad de nadar.
interface Swimmable {
    fun swim()
}


/**

 * 2. CREACIÓN DE LAS CLASES DE ANIMALES
 * Estas clases representan a los animales. Uso el operador ":" para
 * indicar qué interfaces implementa cada clase. Al hacerlo, la clase
 * está obligada a proporcionar una implementación para cada función
 * definida en la interfaz, usando la palabra clave "override".
 */

// La clase Bird (Pájaro) puede volar y caminar.
// Por lo tanto, implementa las interfaces Flyable y Walkable.
class Bird : Flyable, Walkable {
    // Proporciona la implementación específica para la función fly() de la interfaz Flyable.
    override fun fly() {
        println("El pájaro está batiendo sus alas y volando.")
    }

    // Proporciona la implementación específica para la función walk() de la interfaz Walkable.
    override fun walk() {
        println("El pájaro está caminando sobre sus patas.")
    }
}

// La clase Cat (Gato) solo puede caminar.
// Por lo tanto, solo implementa la interfaz Walkable.
class Cat : Walkable {
    // Proporciona la implementación para la función walk().
    override fun walk() {
        println("El gato está caminando sigilosamente.")
    }
}

// La clase Fish (Pez) solo puede nadar.
// Por lo tanto, solo implementa la interfaz Swimmable.
class Fish : Swimmable {
    // Proporciona la implementación para la función swim().
    override fun swim() {
        println("El pez está moviendo sus aletas y nadando.")
    }
}


/**
 * 3. FUNCIÓN PARA PROCESAR LAS ACCIONES DE LOS ANIMALES
 
 * Esta función demuestra el polimorfismo y el "smart casting" de Kotlin.
 */

/**
 * Itera sobre una lista de animales de cualquier tipo y ejecuta las acciones
 * correspondientes a las habilidades que cada animal posee.
 *
 * @param animals Una lista que puede contener cualquier tipo de objeto (List<Any>).
 */
fun animalActions(animals: List<Any>) {
    println("--- Iniciando secuencia de acciones de animales ---")
    // Iteramos sobre cada elemento en la lista de animales.
    for (animal in animals) {
        // Imprimimos el tipo de animal que estamos evaluando para mayor claridad.
        println("\nEvaluando a: ${animal.javaClass.simpleName}")

        // Comprobamos si el objeto 'animal' implementa la interfaz 'Flyable'.
        // Si es así, Kotlin realiza un "smart cast" (conversión inteligente)
        // y nos permite llamar a la función fly() directamente de forma segura.
        if (animal is Flyable) {
            animal.fly()
        }

        // Hacemos lo mismo para la interfaz 'Walkable'.
        if (animal is Walkable) {
            animal.walk()
        }

        // Y finalmente para la interfaz 'Swimmable'.
        if (animal is Swimmable) {
            animal.swim()
        }
    }
    println("\n--- Secuencia de acciones finalizada ---")
}


/**
 * 4. FUNCIÓN PRINCIPAL (PUNTO DE ENTRADA)
 
 * Aquí es donde creamos las instancias de nuestros animales y probamos
 * la función animalActions.
 */
fun main() {
    // Creamos una instancia de cada tipo de animal.
    val myBird = Bird()
    val myCat = Cat()
    val myFish = Fish()

    // Creamos una lista que contiene todas nuestras instancias de animales.
    // La lista es de tipo List<Any> implícitamente, ya que contiene diferentes tipos.
    val allAnimals = listOf(myBird, myCat, myFish)

    // Llamamos a la función animalActions para que procese la lista.
    animalActions(allAnimals)
}
