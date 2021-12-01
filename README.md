# Inscripciones-Tarea-6.-Ing.-Sw-
El programa recibe un archivo de texto con información de inscripciones (Cédula, nombre del estudiante, código y nombre de la materia) y muestra el total de materias que tiene inscritas cada estudiante.
Deberás escoger primero un archivo con el botón "Seleccionar Archivo", posteriormente clickearás en "Mostrar Información", para visualizar tus resultados.


El código se pudo realizar en su mayoría con la ayuda de la especificación de métodos, el diagrama UML y el diagrama de secuencia. Hubieron unos pocos cambios que consideramos necesarios y se listarán a continuación:

Cambios:

• Para no violar LoD, se creó el método agregarCodMateriasCursadas() en la clase Estudiante, el cual recibe el código de la materia y la adiciona a la lista "codigoMateriasCursadas".

• Se creo una nueva funcion en controlRegistro llamada agregarMateria para actualizar la lista del estudiante

• Ahora EstudianteException la lanza la clase ControlRegistro.

• Se eliminó ListaException, puesto que no era necesaria ya que estaba siendo controlada por el método cargarLista().

• Cómo habiamos planteado en el diagrama de secuencia, la ventana tendrá dos métodos de tipo event que son btnSeleccionarArchivoActionPerformed() y btnMostrarInformacionActionPerformed()

• Se agregó el método matricularEstudiante() a la clase ControlRegistro, para cuando el estudiante no existe, lo crea y lo agrega a la lista.

•Se agregaron los métodos guardarRutaArchivoSeleccionado(), cargaDatos(), mostrarInformacion() dentro de la clase Ventana, pues no se tenían contemplados en un principio. Estos métodos son usados para la correcta visualización de la información cargada, en la interfaz gráfica.

