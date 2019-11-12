  
#!/bin/bash

echo "Compilando o arquivo"
javac -cp ./src ./src/main/*.java -d ./out/

echo "Montando executavel .jar"
jar cvfm emulador.jar ./src/META-INF/MANIFEST.MF -C ./out/ .

echo "Tudo pronto!"