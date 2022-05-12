public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
   *complete this method
   */
  void add(OrbNode orb) {
    //insert orb at the end of the list before the last node.
    last.prev.next = orb;
    orb.prev = last.prev;
    last.prev = orb;
    orb.next = last;
  }

  /* Complete this method
   *process all nodes by running move.
   */
  void processAll() {
    OrbNode current = first;
    current.move();
    //advance current to next until it is null, move() each of the nodes
    while (current.next != null) {
      current = current.next;
      current.move();
    }
  }

  /**
   *complete this method
   *Display all nodes by running their display().
   */
  void display() {
    OrbNode current = first;
    current.display();
    //advance current to next until it is null, display() each of the nodes
    while (current.next != null) {
      current = current.next;
      current.display();
    }
  }

  /**
   * Insert
   * > creates a node at mouse position 
   */
  void add(int xcor, OrbNode toBeAdded) {
    OrbNode current = first;
    while (current.x < xcor && current.next != null) {
      current = current.next;
    }
    current.prev.next = toBeAdded;
    toBeAdded.prev = current.prev;
    current.prev = toBeAdded;
    toBeAdded.next = current;
  }

  /**
   * Delete
   * > Delete Node at the mouse
   */
  void delete(OrbNode target) {
    target.prev.next = target.next;
    target.next.prev = target.prev;
  }
  
  /**
   * getNodeAt
   * > Return the first node that x and y are inside the circle
   * > return null if no node is found at the xy coordinate
   */
  OrbNode getNodeAt(int x, int y) {
    OrbNode current = first.next;
    while (current.next != null) {
      if ( dist(x, y, current.x, current.y) <= 30) {
        return current;
      }
      current = current.next;
    }
    return null;
  }
}
