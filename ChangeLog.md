# CHANGELOG

## v1.3.2

### Description
Se corrige el problema de mostrar el dialogo con loading detenido en ciertos casos en Android 8+, ya que se muestra el loading en primer plano en vez de ser descartado.

### Changelog
6de15cba8292933272533ce79894d1b4f3010d34 - Se modifica evento al cerrar dialog

## v1.3.1

### Description
Se realizan correcciones en el id y nombre del plugin.

### Changelog
24a172e11d09f5c76ab65ec7241f6c3d27cd943b - Se reemplazan los nombres y IDs a kunder-cordova-plugin-native-loading
a9100327a4b10f5f8a3855ed040fbb1d12937ebc - cambio de nombre siguiendo las notaciones actuales
7695927419dde9593c6e0607f9983431314c4802 - corrección
a7a6eab6fc939e30ab2a38354749abb49a362ac8 - se modifican las variable id y name
fe7a20730f0285a2eb66e6ef266cf33f506be5a2 - modificación id del plugin
6289bf39a36abf62231fb68fad6662a31e8a31a5 - modificación variable "name"
96568e9f9bad2761d0ce3dc7d48035c5b764dde0 - se remueve .classpath
303203514e354df40a76b93415c03f729b19e490 - modificación keywords
708430887181ace2bba6a298d581757ff9dfdff9 - corrección nombre author
f4937edf4354d0961c305a2c33be2d1956e090f9 - modificación a version del plugin
cb64e3ed46581cc55698e27ffcf31d99cfc87de9 - cambio de nombre en plugin
f4ed0a638503efe45b9c62de6df8622021d6ce1b - actualización plugin
603e4218fac9fd679a9307fe1e86d0b22b7c83b8 - version fix
71fff7b3d911735755c6d14007598b570aeafde5 - name fix
0308a586996347f7a798b9c469b7431b7c80daaa - package.json
5e60f8f019b844f061a7b2b39be85964d3651042 - Removed empty intent-filter tags to prevent error in processing of application manifest
0c9dcb9006d68734ea316f56abe3e04e393d2de5 - Fix indentation
87291ffb2746f583162eca96a84128100942b923 - Updated README with compatibility explanation

## v1.3.0

### Description
Se añade package.json para ser utilizado con Cordova 7.
Se ignoran los eventos del backbutton en Android.
Se corrigen problemas de librerías.
Se realizan correcciones menores.

### Changelog
fbb18b031276bf68d575ade699bbc50590845736 - cambio de referencia a kunder
a70a9e7839949a258e40286c8840a8d698be9841 - se agrega package.json
f33d1c1805756967033e1b6670f7d240a19689c7 - Se agregaron las librerias faltantes
ac31a81669539f82a7629e5817e2b0d3be334abc - Se ha añadido algunos listeners que capturan el evento del backbutton con el fin de anular la acción sobre el dialogo. Ahora el dialogo no puede ser cerrado por el usuario.
7fd3c1c984e8187f1836959057e4f92697b0f485 - Se ha quitado la funcion onBackPressed
cdd221bf969b27401ba5dd5590adcb6cb80bd71d - Se ha especificado que el evento de presionar sobre el backbutton en Android no sea considerado por el loading nativo. Dicho evento debería capturarse en la interfaz principal y debería cerrar este loading.
7341fb5afc6aac2b8f04938e03a79ea6a20d8fda - Se ha añadido transparencia al fondo del loading
042eb215089f32b68e1b325e1891fbe2ada39c1b - readme title
d13f2732741326dbb61ceb1fbef736381eb7acfb - cambio ruta de android
ed455d64a243ef5ab27c11c2912ec3886a86801e - cambio de id y limpieza del plugin
7c0bbba63dbadee2a9f46d21de4e957a455c56e3 - Se ha quitado la transparencia del color de fondo del diálogo en android.
8797191d83ee7be3fa8d874f4ef22a4dfbb30aed - Se han quitado los android manifest, ya que no son necesarios. Se ha modificado el plugin.xml
6f5d4bc86c9f68179577959c32bf211f6d0e4228 - Se ha reemplazado el Activity por Dialog, con el fin de eliminar el problema del ámbito.
99d5bff2c1898f12f33023789945570cd6c77e73 - Correccion error android
d541e935c5d331105e53219905f5a8c6813c7eae - Se llaman mediante hilos.
6b96a26fb05626334fd32f72f39c59efdceab259 - Solucion de un problema el cual ocultaba el loading si se invocaba 2 veces.
62cb5f25f2b7a0090f6a55e4f3536ba3695e9943 - Solucionado un problema con iOS
cf55ca6f9f6d708f452c6bc90153ec4cedaf94a9 - Se ha dejado el fondo en negro sin transparencias.
cf85e5d13e989e516481483f8d7f9de118b9211c - Se ha modificado la función hide().
c7d7d93bfecdda8e5926835db4a7afeb5ff39ad0 - optimización del código. Se han quitado componentes que no se utilizarán.
84e14612056cffdecc87326f353f62fc6db4f7b4 - Se ha modificado la vista de loading para iOS, acorde al diseño.
2347b7fae6881788a2dc7fc2475040f517bf89fc - Se ha adaptado la vista de loading para Android.
17e52e27245c75f0fb8a0dcba01f2106f69d2c00 - Fix Issue 20 in Android: fullscreen property seem not work
