export class Group {
  idGroup: string;
  groupName: string;

  // constructor( idGroup: string, groupName: string) {
  //   this.idGroup = idGroup;
  //   this.groupName = groupName;
  // }

  static cloneBase(group: Group): Group{
    const cloneGroup: Group = new Group();
    cloneGroup.idGroup = group.idGroup;
    cloneGroup.groupName = group.groupName;
    return cloneGroup;
  }

}


