 import java.util.Random;

class HashMap
{ 
    public int collision=0;
            
    private HashNode[] bucketArray; // the array to store the front of each LinkedList 
    private int numBuckets=10; // the size of the array 
    private int size; // the total number of elements in the HashMap
    private int hashing; // defines which hashing function to use, since there are 2, can be either 0 or 1
    
    public HashMap(int hashing) 
    { 
        this.hashing = hashing;
        // TODO: your code here to initialize the hash map
        bucketArray=new HashNode[numBuckets];
    } 
  
    public int size() { return size; } 
    
    public boolean isEmpty() { return size() == 0; } 
    
    private int hashFirst(Student node) { 
        String studentName=node.name;
        int sum = 0;
        for(char a:studentName.toCharArray()) {
            sum+=(int)a;
        }
        
        return sum;
    }
    
    private int hashSecond(Student node) {
        
        return (int)(node.name.charAt(0));
    }
    private int getBucketIndex(Student key) 
    { 

        if (hashing == 0) {
            return hashFirst(key) % numBuckets;
        } else if (hashing == 1) {
            return hashSecond(key) % numBuckets;
        } else {
            return 0;
        }
    } 
  
    public Advisor remove(Student key) 
    { 
        // TODO: your code here to remove an element from the HashMap and return its corresponding value

        int index=getBucketIndex(key);
        
        if(bucketArray[index]==null) return null;

        HashNode iterator=bucketArray[index];
        
        if(iterator.key.equals(key)) 
        {
            HashNode temp=iterator;
            bucketArray[index]=iterator.next;
            size--;
            return temp.value;
        }
  
        while(iterator.next!=null)
        {
 
            if(iterator.next.key.equals(key)) 
            {
            
                HashNode temp=iterator.next;
                iterator.next=iterator.next.next;
                size--;
                return temp.value;
            }
            iterator=iterator.next;
        }
        
        return null; 
        
    } 
  
    public Advisor get(Student key) 
    {
        // TODO: your code here to get the corresponding value (Advisor) of the key (Student)
        int index=getBucketIndex(key);
        
        HashNode iterator=bucketArray[index];
        if(iterator.key.equals(key))return iterator.value;
  
        while(iterator.next!=null)
        {
            iterator=iterator.next;
            if(iterator.key.equals(key))return iterator.value;
        }
        
        return null; 
    } 
  
    public void add(Student key, Advisor value) 
    { 
        // TODO: your code here to add the key-value pair to the HashMap
        int index=getBucketIndex(key);
        boolean duplicateExist=false; //if we have a key already, we shouldn't add to the list

        HashNode newNode=new HashNode(key,value);
        if(bucketArray[index]==null) 
        {
            bucketArray[index]=newNode;
            size++;
        }
        else 
        {
            collision++;
            HashNode iterator=bucketArray[index];
            
            if(iterator.key.equals(key)) 
            {
                duplicateExist=true;
            }
            
            while(iterator.next!=null&&!duplicateExist)
            {
                iterator=iterator.next;
                if(iterator.key.equals(key)) 
                {
                    duplicateExist=true;
                }
            }
            if(!duplicateExist) 
            {
                iterator.next=newNode;
                size++;
            }
            
        }
    }  
   
}



public class HashMain {
    // Driver method to test Map class 
    public static void main(String[] args) 
    { 
        HashMap map = new HashMap(1); 
        map.add(new Student("Ahmet", 1, 3.91), new Advisor("Mehmet", "Mathematics")); 
        Student harry = new Student("Harry", 2, 3.22);
        Advisor dumbledore = new Advisor("Dumbledore", "Wizardy");
        map.add(harry, dumbledore); 
        map.add(new Student("Hermione", 3, 4.0), dumbledore); 
        map.add(new Student("Jesse", 4, 2.17), new Advisor("Walter White", "Chemistry")); 
        System.out.println(map.size()); 
        System.out.println(map.remove(harry)); 
        System.out.println(map.remove(harry)); 
        System.out.println(map.size()); 
        System.out.println(map.isEmpty());
        
 
        
    } 
    
    
    
} 
