# cvds-lab4
# Part I
1. Clone el proyecto (no lo descargue!).

![1](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan.png)
   
2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.

3. Haga la especificación de los métodos calculateScore (de las tres
   variantes de GameScore), a partir de las especificaciones
   generales dadas anteriormente. Recuerde tener en cuenta: @pre,
   @pos, @param, @throws.

5. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8 .

![2](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan1.png)

6. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera. 

7. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.

9. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.


![3](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan2.png)


# Part II


Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar createGUIUsingFactoryMethod en SwingProject, el
constructor de la clase GUI y HangmanFactoryMethod).

En este taller se va a utilizar un contenedor liviano ([GoogleGuice](https://github.com/google/guice)) el cual soporta la inyección de las dependencias.

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

Incorpore el Contenedor Liviano Guice dentro del proyecto:

* Revise las dependencias necesarias en el pom.xml.
* Modifique la inyección de dependencias utilizando guice en lugar del
  método fábrica..
* Configure la aplicación de manera que desde el programa SwingProject
  NO SE CONSTRUYA el Score directamente, sino a través de Guice, asi
  mismo como las otras dependencias que se están inyectando mediante
  la fabrica.
* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
	* Utilizar el esquema OriginalScore.
	* Utilizar el esquema BonusScore.
	* Utilizar el idioma francés.
    * Utilizar el diccionario francés.
	* etc...
 
 ![4](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan3.png)
 
 ![5](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan4.png)
 
 ![6](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan5.png)
 
 ![7](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan6.png)
 
 ![8](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPan7.png)
 
 ![9](https://github.com/Juc28/cvds-lab4/blob/master/pantallazos/CapturaPant8.png)

# Tomado de:
* [Repositorio Original](https://github.com/PDSW-ECI/LigthwayContainer_DependencyInjection_Hangman)

## Contributors

> Juliana Castro [Juc28](https://github.com/Juc28)
>
> Mariana Pulido [MPulidoM](https://github.com/MPulidoM)
