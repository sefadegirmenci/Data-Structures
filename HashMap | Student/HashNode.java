// node of the LinkedList 
public class HashNode
{ 
    Student key; 
    Advisor value; 
    //this is the link to the next node in the chain
    HashNode next; 
  
    public HashNode(Student key, Advisor value) 
    { 
        this.key = key; 
        this.value = value; 
    } 
}
