public void sortList(){
    myElement temp;
    myElement[] ob = new myElement[listModel.getSize()];
    for(int i = 0 ; i <listModel.getSize(); i++ )
        ob[i] = listModel.getElementAt(i);
    int n=ob.length;
    for(int i=0;i<n;i++)
        for(int j=0;j<n-i-1;j++)
        {
            if(ob[j].toString().compareTo(ob[j+1].toString())>0) // used to sort strings
            {
             temp=ob[j];
             ob[j]=ob[j+1];
             ob[j+1]=temp;
            }
 
          }
    listModel.removeAllElements();
    for(int i=0;i<n;i++)
      listModel.addElement((myElement) ob[i]);
    System.out.println("sort!");
 
}