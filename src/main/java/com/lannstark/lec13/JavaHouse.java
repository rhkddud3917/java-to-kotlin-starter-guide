package com.lannstark.lec13;

public class JavaHouse {

  private String address;
  private LivingRoom livingRoom;

  public JavaHouse(String address) {
    this.address = address;
    this.livingRoom = new LivingRoom(10);
  }

  public LivingRoom getLivingRoom() {
    return livingRoom;
  }

  public class LivingRoom {
    private double area;

    public LivingRoom(double area) {
      this.area = area;
    }

    public String getAddress() {
      // 바깥 클래스와 연결되어 있어 바깥 클래스를 바로 참조해서 this.address로 바깥 클래스의 필드를 가져온다
      return JavaHouse.this.address;
    }
  }

}