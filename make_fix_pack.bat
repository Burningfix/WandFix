cd ./app/build/intermediates/classes/debug/
jar cvf hotfix_pack.jar  ./com/miqt/demo/proxy/TextActivityProxy.class ./com/miqt/demo/proxy/TextActivityProxy$*.class ./com/miqt/demo/TextFixBean.class ./com/miqt/demo/TextFixBean$*.class
dx --dex --output=../../../../../hotfix_pack.dex hotfix_pack.jar
cd ../../../../../
