# MyArrayListAndLinkedList
My own realization of ArrayList and LinkedList

In my demo-app I created MyArrayList, wich contains colors of rainbow (7) and MyLinkedList, wich contains degrees of number 2 (from 1 to 128). To test the program, use the following functions:


Build

$ ./mvnw clean package

##Array list


toStringArrayList

$ java -jar target/app.jar toStringArrayList


addByIndexToArrayList

$ java -jar target/app.jar addByIndexToArrayList -vA newValue -iA index


addToArrayList

$ java -jar target/app.jar addToArrayList -vA newValue


getByIndexFromArrayList

$ java -jar target/app.jar getByIndexFromArrayList -iA index


removeByIndexFromArrayList

$ java -jar target/app.jar removeByIndexFromArrayList -iA index


updateByIndexInArrayList

$ java -jar target/app.jar updateByIndexInArrayList -vA newValue -iA index


sizeOfArrayList

$ java -jar target/app.jar sizeOfArrayList


getCapacityOfArrayList

$ java -jar target/app.jar getCapacityOfArrayList

##Linked list


toStringLinkedList

$ java -jar target/app.jar toStringLinkedList


addByIndexToLinkedList

$ java -jar target/app.jar addByIndexToLinkedList -vL newValue -iL index


addFirstToLinkedList

$ java -jar target/app.jar addFirstToLinkedList -vL newValue


addLastToLinkedList

$ java -jar target/app.jar addLastToLinkedList -vL newValue


getByIndexFromLinkedList

$ java -jar target/app.jar getByIndexFromLinkedList -iL index


getFirstFromLinkedList

$ java -jar target/app.jar getFirstFromLinkedList


getLastFromLinkedList

$ java -jar target/app.jar getLastFromLinkedList


removeByIndexFromLinkedList

$ java -jar target/app.jar removeByIndexFromLinkedList -iL index


removeFirstFromLinkedList

$ java -jar target/app.jar removeFirstFromLinkedList


removeLastFromLinkedList

$ java -jar target/app.jar removeLastFromLinkedList


updateByIndexInLinkedList

$ java -jar target/app.jar updateByIndexInLinkedList -vL newValue -iL index


sizeOfLinkedList

$ java -jar target/app.jar sizeOfLinkedList
