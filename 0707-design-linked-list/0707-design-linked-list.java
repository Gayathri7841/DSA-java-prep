class MyLinkedList {
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}
Node root;
int size;
    public MyLinkedList() {
   root=null;
   size=0;  
    }
    
    public int get(int index) {
        if(index<0||index>=size) return -1;
        Node temp=root;
        int pos=0;
        while(temp!=null&&pos<index){
            temp=temp.next;
            pos++;
        }
    
      return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newnode=new Node(val);
      
        
            newnode.next=root;
            root=newnode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newnode =new Node(val);
        if(root==null){
            root=newnode;
        }else{
            Node temp=root;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;

        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0||index>size) return;
        if(index==0){
            addAtHead(val);
            return;
        }
if(index==size){
    addAtTail(val);
    return;
}
        Node newnode =new Node(val);
       
        Node temp=root;
       
      for(int i=0;i<index-1;i++){
           
            temp=temp.next;

        }
       
        newnode.next=temp.next;
        temp.next=newnode;  
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;
        if(index==0){
            root=root.next;
            size--;
            return;
        }
        Node temp=root;
      
        for(int i=0;i<index-1;i++){
            
            temp=temp.next;
    
        }
    temp.next=temp.next.next;
size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */