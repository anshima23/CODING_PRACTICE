class sum_of_sq_no {

    public static boolean isPerfectSquare(int num) {
      if (num < 0) return false;
      int sqrt = (int) Math.sqrt(num);
      return (sqrt * sqrt == num);
  }


  public boolean judgeSquareSum(int c) {
        for(int i =0;i<=(int) Math.sqrt(c);i++){
          if(isPerfectSquare(c-i*i)){return true;}
        }
        return false;
  }
}