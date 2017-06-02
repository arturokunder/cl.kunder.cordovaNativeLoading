# CHANGELOG

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
