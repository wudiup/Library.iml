import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library {
    public static void librarySystem() {
        ArrayList<Book> arrBook = new ArrayList<>();
        ArrayList<Administrator> arrAdministrator = new ArrayList<>();
        ArrayList<User> arrUser = new ArrayList<>();
        Book book1 = new Book("西游记", "吴承恩", "1", 2, 30);
        Book book2 = new Book("红楼梦", "曹雪芹", "2", 1, 35);
        Book book3 = new Book("三国演义", "罗贯中", "3", 3, 30);
        Book book4 = new Book("Java基础入门", "黑马程序员", "4", 0, 30);
        Book book5 = new Book("水浒传", "施耐庵", "5", 1, 30);
        arrBook.add(book1);
        arrBook.add(book2);
        arrBook.add(book3);
        arrBook.add(book4);
        arrBook.add(book5);
        Administrator administrator1 = new Administrator("小张", "2128001", "123456");
        Administrator administrator2 = new Administrator("小郭", "2128002", "654321");
        Administrator administrator3 = new Administrator("小陈", "2128003", "987654");
        Administrator administrator4 = new Administrator("小王", "2128004", "456789");
        Administrator administrator5 = new Administrator("小李", "2128005", "012345");
        arrAdministrator.add(administrator1);
        arrAdministrator.add(administrator2);
        arrAdministrator.add(administrator3);
        arrAdministrator.add(administrator4);
        arrAdministrator.add(administrator5);
        User user1 = new User("张三", "210001", "123456",false,"Java基础入门");
        User user2 = new User("李四", "210002", "234561",true,"无");
        User user3 = new User("王五", "210003", "234516",true,"无");
        User user4 = new User("赵六", "210004", "512346",true,"无");
        User user5 = new User("小明", "210005", "134256",true,"无");
        arrUser.add(user1);
        arrUser.add(user2);
        arrUser.add(user3);
        arrUser.add(user4);
        arrUser.add(user5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用图书管理系统！");
            System.out.println("1、管理员\n" + "2、普通用户\n" + "0、退出系统");
            System.out.print("请选择您的身份：");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    administratorFunction(arrAdministrator, sc,arrBook);
                    break;
                case 2:
                    userFunction(arrUser,sc,arrBook);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("您的选择有误，请重新输入！");
            }
        }
    }

    /**
     * 管理员功能
     */
    private static void administratorFunction(ArrayList<Administrator> arrAdministrator, Scanner sc,ArrayList<Book> arrBook) {
        while (true) {
            System.out.println("管理员首页");
            System.out.println("1、账户登录");
            System.out.println("2、账户注册");
            System.out.println("0、返回主页");
            System.out.print("请选择你的操作：");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    //登录
                    login1(arrAdministrator, sc,arrBook);
                    break;
                case 2:
                    //注册
                    register1(arrAdministrator,sc);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("您的选择有误，请重新输入！");
            }
        }
    }

    /**
     * 普通用户功能
     */
    private static void userFunction(ArrayList<User> arrUser,Scanner sc,ArrayList<Book> arrBook) {
        loop:while (true) {
            System.out.println("普通用户首页");
            System.out.println("1、账户登录");
            System.out.println("2、账户注册");
            System.out.println("3、返回主页");
            System.out.print("请选择你的操作：");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    //登录
                    login2(arrUser, sc,arrBook);
                    break;
                case 2:
                    //注册
                    register2(arrUser,sc);
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("您的选择有误，请重新输入！");
            }
        }

    }

    /**
     * 管理员登录
     */
    private static void login1(ArrayList<Administrator> arrAdministrator, Scanner sc,ArrayList<Book> arrBook) {
        System.out.println("管理员登录功能！");
        if (arrAdministrator.size() < 1) {
            System.out.println("此系统无账号，无法进行登录，先注册一个吧！");
            return;
        }
        while (true) {
            System.out.print("请输入帐号：");
            String administratorID = sc.next();
            Administrator acc = getAccountByCardId1(administratorID, arrAdministrator);
            if (acc != null) {
                while (true) {
                    System.out.print("请输入密码：");
                    String password = sc.next();
                    if (acc.getAdministratorPassword().equals(password)) {
                        System.out.println("恭喜您，登录成功！");
                        while (true) {
                            System.out.println("管理员功能如下：");
                            System.out.println("1、添加书籍\n" + "2、删除书籍\n" + "3、查询图书信息\n"+"4、修改密码\n" + "5、注销账户\n" + "6、退出此账号");
                            System.out.print("请选择你要办理的业务：");
                            int command = sc.nextInt();
                            switch (command){
                                case 1:
                                    //添加书籍
                                    addBook(sc,arrBook);
                                    break;
                                case 2:
                                    //删除书籍
                                    deleteBook(arrBook,sc);
                                    break;
                                case 3:
                                    //查询图书信息
                                    queryBook(arrBook);
                                    break;
                                case 4:
                                    //修改密码
                                    updatePassword1(acc,sc);
                                    return;
                                case 5:
                                    //注销账户
                                    System.out.println("您确定要注销此账号吗？\n"+"1、确定\n"+"2、不注销");
                                    System.out.println("请输入您的选择：");
                                    int rc=sc.nextInt();
                                    switch (rc){
                                        case 1:
                                            arrAdministrator.remove(acc);
                                            System.out.println("注销成功");
                                            return;
                                        case 2:
                                        default:
                                            System.out.println("已取消注销账号！");
                                    }
                                    break;
                                case 6:
                                    //退出此账号
                                    return;
                                default:
                                    System.out.println("您的选择有误，请重新输入！");
                            }
                        }
                    }
                    else
                        System.out.println("您输入的密码错误，请重新输入！");
                }
            }
            else
                System.out.println("您输入的账号有误，请重新输入！");
        }
    }

    /**
     * 管理员删除书籍
     */
    private static void deleteBook(ArrayList<Book> arrBook,Scanner sc) {
        while (true) {
            System.out.print("请输入您要删除书籍名称：");
            String bookName=sc.next();
            int intdex=getIndex(arrBook,bookName);
            if(intdex>=0){
                arrBook.remove(intdex);
                System.out.println("删除成功！");
                break;
            }
            else
                System.out.println("您输入的书籍名称不存在，请重新输入");
        }
    }

    /**
     *判断书籍是否存在存在
     */
    public static int getIndex (ArrayList<Book> arrBook,String bookName){
        for (int i = 0; i < arrBook.size(); i++) {
            Book book=arrBook.get(i);
            String name=book.getBookName();
            if(bookName.equals(name)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 管理员添加书籍
     */
    private static void addBook(Scanner sc,ArrayList<Book> arrBook) {
        Book book=new Book();
        System.out.print("请输入书籍名称：");
        String bookName=sc.next();
        book.setBookName(bookName);
        System.out.print("请输入该书的作者：");
        String writer=sc.next();
        book.setWriter(writer);
        String number= null;
        while (true) {
            System.out.print("请输入该书的编号：");
            number = sc.next();
            boolean b =contains(arrBook,number);
            if(b==true){
                System.out.println("您输入的编号已经存在，请重新输入！");
            }
            else {
                book.setNumber(number);
                break;
            }
        }
        System.out.print("请输入该书剩余本书：");
        int count=sc.nextInt();
        book.setCount(count);
        System.out.print("请输入该书的定价：");
        double money=sc.nextDouble();
        book.setMoney(money);
        arrBook.add(book);
        System.out.println("恭喜您，添加成功！");
    }

    /**
     * 判断书号是否存在
     */
    public static boolean contains(ArrayList<Book> arrBook,String number){
        for (int i = 0; i < arrBook.size(); i++) {
            Book book=arrBook.get(i);
            String Number=book.getNumber();
            if(number.equals(Number))
                return true;
        }
        return false;
        //return getIndex(arrBook,number)>=0;
    }

    /**
     * 管理员注册功能
     */
    private static void register1(ArrayList<Administrator> arrAdministrator,Scanner sc) {
        System.out.println("管理员注册操作！");
        Administrator administrator = new Administrator();
        System.out.print("请输入用户名：");
        String name = sc.next();
        administrator.setName(name);
        while (true) {
            System.out.print("请输入密码：");
            String password = sc.next();
            System.out.print("请再次输入密码：");
            String okpassword = sc.next();
            if (password.equals(okpassword)) {
                administrator.setAdministratorPassword(okpassword);
                break;
            } else
                System.out.println("您两次输入密码不一致，请重新输入！");
        }
        String administratorID=getRandomCardID1(arrAdministrator);
        administrator.setAdministratorID(administratorID);
        arrAdministrator.add(administrator);
        System.out.println("恭喜您，"+name+"先生/女士注册成功。您的帐号是："+administratorID+".请妥善保存！");
    }

    /**
     * 生成管理员帐号
     */
    private static String getRandomCardID1(ArrayList<Administrator> arrAdministrator){
        String administratorID="2128";
        Random r=new Random();
        while (true) {
            for (int i = 0; i < 3; i++) {
                administratorID+=r.nextInt(10);
            }
            Administrator acc=getAccountByCardId1(administratorID,arrAdministrator);
            if(acc==null){
                return administratorID;
            }
        }
    }

    /**
     *查询是否存在该管理员账号
     */
    private static Administrator getAccountByCardId1(String administratorID,ArrayList<Administrator> arrAdministrator){
        for (int i = 0; i < arrAdministrator.size(); i++) {
            Administrator acc=arrAdministrator.get(i);
            if(acc.getAdministratorID().equals(administratorID)){
                return acc;
            }
        }
        return null;
    }

    /**
     *管理员修改密码
     */
    private static void updatePassword1(Administrator acc, Scanner sc) {
        while (true) {
            System.out.print("请输入原密码：");
            String password=sc.next();
            if(acc.getAdministratorPassword().equals(password)){
                while (true) {
                    System.out.print("请输入新密码：");
                    String newPassword1=sc.next();
                    System.out.print("请再次输入新密码：");
                    String newPassword2=sc.next();
                    if(newPassword1.equals(newPassword2)){
                        if(acc.getAdministratorPassword().equals(newPassword2)){
                            System.out.println("新密码和老密码一致，请重新输入！");
                            continue;
                        }
                        acc.setAdministratorPassword(newPassword2);
                        System.out.println("密码修改成功，请重新登录！");
                        return;
                    }
                    else{
                        System.out.println("您两次输入的密码不一致，请重新输入！");
                    }
                }
            }
            else{
                System.out.println("您输入的密码有误，请重新输入！");
            }
        }
    }

    /**
     *普通用户登录
     */
    private static void login2(ArrayList<User> arrUser, Scanner sc,ArrayList<Book> arrBook) {
        System.out.println("普通用户登录功能！");
        if (arrUser.size() < 1) {
            System.out.println("此系统无账号，无法进行登录，先注册一个吧！");
            return;
        }
        loop:while (true) {
            System.out.print("请输入帐号：");
            String userID = sc.next();
            User acc = getAccountByCardId2(userID, arrUser);
            if (acc != null) {
                while (true) {
                    System.out.print("请输入密码：");
                    String password = sc.next();
                    if (acc.getUserPassword().equals(password)) {
                        System.out.println("恭喜您，登录成功！");
                        while (true) {
                            System.out.println("普通用户功能如下：");
                            System.out.println("1、借阅书籍\n" + "2、归还书籍\n" +"3、查询图书信息\n"+"4、查询已借书籍\n"+"5、修改密码\n" + "6、注销账户\n" + "7、退出此账号");
                            System.out.print("请选择你要办理的业务：");
                            int command = sc.nextInt();
                            switch (command){
                                case 1:
                                    //借阅书籍
                                    BorrowBooks(arrBook,acc);
                                    break;
                                case 2:
                                    //归还书籍
                                    ReturnBooks(arrBook,acc);
                                    break;
                                case 3:
                                    //查询图书信息
                                    queryBook(arrBook);
                                    break;
                                case 4:
                                    //查询已借书籍
                                    queryBorrowBook(acc);
                                    break;
                                case 5:
                                    //修改密码
                                    updatePassword2(acc,sc);
                                    return;
                                case 6:
                                    //注销账户
                                    if(!acc.isFlag()){
                                        System.out.println("你目前仍有借书尚未归还！请在归还后再次申请注销！");
                                        break ;
                                    }
                                    else{
                                    System.out.println("您确定要注销此账号吗？\n"+"1、确定\n"+"2、不注销");
                                    System.out.println("请输入您的选择：");
                                    int rc=sc.nextInt();
                                    switch (rc){
                                        case 1:
                                            arrUser.remove(acc);
                                            System.out.println("注销成功");
                                            return;
                                        case 2:
                                        default:
                                            System.out.println("已取消注销账号！");
                                    }
                                        }
                                    break;
                                case 7:
                                    //退出此账号
                                    break loop;
                                default:
                                    System.out.println("您的选择有误，请重新输入！");
                            }
                        }
                    }
                    else
                        System.out.println("您输入的密码错误，请重新输入！");
                }
            }
            else
                System.out.println("您输入的账号有误，请重新输入！");
        }
    }

    /**
     *普通用户注册
     */
    private static void register2(ArrayList<User> arrUser, Scanner sc) {
        System.out.println("普通用户注册操作！");
        User user = new User();
        System.out.print("请输入用户名：");
        String name = sc.next();
        user.setUserName(name);
        while (true) {
            System.out.print("请输入密码：");
            String password = sc.next();
            System.out.print("请再次输入密码：");
            String okpassword = sc.next();
            if (password.equals(okpassword)) {
                user.setUserPassword(okpassword);
                break;
            } else
                System.out.println("您两次输入密码不一致，请重新输入！");
        }
        String userID=getRandomCardID2(arrUser);
        user.setUserID(userID);
        arrUser.add(user);
        System.out.println("恭喜您，"+name+"先生/女士注册成功。您的帐号是："+userID+".请妥善保存！");
    }

    /**
     * 生成普通用户帐号
     */
    private static String getRandomCardID2(ArrayList<User> arrUser){
        String userID="21";
        Random r=new Random();
        while (true) {
            for (int i = 0; i < 4; i++) {
                userID+=r.nextInt(10);
            }
            User acc=getAccountByCardId2(userID,arrUser);
            if(acc==null){
                return userID;
            }
        }
    }

    /**
     *查询是否存在该普通用户账号
     */
    private static User getAccountByCardId2(String userID,ArrayList<User> arrUser){
        for (int i = 0; i < arrUser.size(); i++) {
            User acc=arrUser.get(i);
            if(acc.getUserID().equals(userID)){
                return acc;
            }
        }
        return null;
    }

    /**
     *普通用户修改密码
     */
    private static void updatePassword2(User acc, Scanner sc) {
        while (true) {
            System.out.print("请输入原密码：");
            String password=sc.next();
            if(acc.getUserPassword().equals(password)){
                while (true) {
                    System.out.print("请输入新密码：");
                    String newPassword1=sc.next();
                    System.out.print("请再次输入新密码：");
                    String newPassword2=sc.next();
                    if(newPassword1.equals(newPassword2)){
                        if(acc.getUserPassword().equals(newPassword2)){
                            System.out.println("新密码和老密码一致，请重新输入！");
                            continue;
                        }
                        acc.setUserPassword(newPassword2);
                        System.out.println("密码修改成功，请重新登录！");
                        return;
                    }
                    else{
                        System.out.println("您两次输入的密码不一致，请重新输入！");
                    }
                }
            }
            else{
                System.out.println("您输入的密码有误，请重新输入！");
            }
        }
    }

    /**
     * 查询书籍
     */
    private static void queryBook(ArrayList<Book> arrBook) {
        System.out.println("欢迎使用查询功能！");
        if(arrBook.size()==0){
            System.out.println("此系统中尚未收藏图书，不能进行查询！");
            return;
        }
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n","书名","作者","编号","剩余本数","定价");
        for (int i = 0; i < arrBook.size(); i++) {
            Book book=arrBook.get(i);
            System.out.printf("%-15s%-15s%-15s%-15d%-15.0f\n",book.getBookName(),book.getWriter(),book.getNumber(),book.getCount(),book.getMoney());
        }
    }

    /**
     * 查询借阅书籍
     */
    private static void queryBorrowBook(User acc){

            if (acc.isFlag()) {
                System.out.println("尚未借阅图书！");
                return;
            }
            else {
                System.out.println("你所借阅的图书为："+acc.getBorrowBooK());
            }
    }


    /**
    * 普通用户借书
    */
    private static void BorrowBooks(ArrayList<Book> arrBook,User acc){
        //第一个if首先判断用户借阅书籍是否上限
        boolean flag1=acc.isFlag();
        if(flag1) {
            loop:while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入你所借书的名称：");
                String num1 = sc.next();
                for (int i = 0; i < arrBook.size(); i++) {
                    String num2 = arrBook.get(i).getBookName();
                    //第二个if判断名称是否正确
                    if (num1.equals(num2)) {
                        int count = arrBook.get(i).getCount();
                        System.out.println("你所借阅的书籍为" + arrBook.get(i).getBookName());
                        //第三个if判断对应书籍是否还有存本
                        if (count > 0) {
                            System.out.println("借阅成功！请在观看后即时归还书籍！");
                            acc.setFlag(false);
                            acc.setBorrowBooK(arrBook.get(i).getBookName());
                            count--;
                            arrBook.get(i).setCount(count);
                            return;
                        } else {
                            System.out.println("你所借阅的书籍" + arrBook.get(i).getBookName() + "暂无存本！请借阅其它书籍！");
                        }
                    }
                }
                System.out.println("你所输入的名称错误！请再次检查后重新输入！");
            }


        }
        else {
            System.out.println("你所借书目已超上限，请在归还借阅书本后，再次借阅！");
        }
    }

    /**
    *普通用户还书
     */
    private static void ReturnBooks(ArrayList<Book> arrBook,User acc){
        Scanner sc = new Scanner(System.in);
        loop:while (true) {
            System.out.println("输入所归还书籍名称(区分大小写)：");
            String BookName=sc.next();
            if (BookName.equals(acc.getBorrowBooK())){
                System.out.println("归还"+BookName+"成功！");
                for (int i = 0; i < arrBook.size(); i++) {
                    if (BookName.equals(arrBook.get(i).getBookName())){
                        int count=arrBook.get(i).getCount();
                        acc.setFlag(true);
                        count++;
                        arrBook.get(i).setCount(count);
                        break loop;
                    }
                }
            }
            else{
                System.out.println("书籍名称与借阅书本不一致！请重新输入！");
            }
        }

    }
}
