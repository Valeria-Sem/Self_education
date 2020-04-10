export class Group {
  idGroup: string;
  groupName: string;

  constructor( groupName: string) {
    this.groupName = groupName;
  }

  // static cloneBase(group: Group): Group{
  //   const cloneGroup: Group = new Group();
  //   cloneGroup.idGroup = group.idGroup;
  //   cloneGroup.groupName = group.groupName;
  //   return cloneGroup;
  // }

}


