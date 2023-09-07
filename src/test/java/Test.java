import com.demo.model.TestEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String args[]) throws Exception
    {
//        List<String> listOfUserNames=new ArrayList<>();
//        listOfUserNames.add("@#");
//        listOfUserNames.add("java2blog]");
//        listOfUserNames.add("java2blog<");
//        listOfUserNames.add("java2blog;");
//        listOfUserNames.add("Java-2-blog");
//        listOfUserNames.add("Java2blog Tutorials");
//        listOfUserNames.add("Java2blogTutorials");
//        listOfUserNames.add("daJ(");
//
//        String regex = "^[a-zA-Z0-9\\s@'#%.,:()[-]+_;<>{}\\]\\[]+$";
//
//        Pattern pattern = Pattern.compile(regex);
//
//        for (String name : listOfUserNames)
//        {
//            Matcher matcher = pattern.matcher(name);
//            System.out.println("Only Alphanumeric in "+name+" : "+ matcher.matches());
//        }


        String data = "124213555555555555555555555555555555";
        Signature sign = Signature.getInstance("RSASSA-PSS");
        PSSParameterSpec pssParams = new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"),
                MessageDigest.getInstance("SHA-256").getDigestLength(), 1);
        sign.setParameter(pssParams);
        sign.initSign(loadPrivateKey());
        sign.update(data.getBytes(StandardCharsets.UTF_8));
        Base64.Encoder encoder = Base64.getEncoder();
        encoder.encodeToString(sign.sign());
    }

    public  List<TestEntity> getAll() throws Exception {
        String data = "124213555555555555555555555555555555";
        Signature sign = Signature.getInstance("RSASSA-PSS");
        PSSParameterSpec pssParams = new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"),
                MessageDigest.getInstance("SHA-256").getDigestLength(),1);
        sign.setParameter(pssParams);
        sign.initSign(loadPrivateKey());
        sign.update(data.getBytes(StandardCharsets.UTF_8));
        Base64.Encoder encoder = Base64.getEncoder();
        encoder.encodeToString(sign.sign());

        return null;
    }


    public static PrivateKey loadPrivateKey()
            throws Exception {
        String privateKey ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC/Gi51ZPSPr2NOWBoiv9Bf9N8t7n9EYE08sk/UqgVSWEuEhnDMp/vZCDL41sKRs/HxYYfrzK835ekKJMOF7AcCgfLsqD6M39t5FV+nmc8i/n2JCgL6QH6I9aCg00PFjuqo0EzF8FPV3VfG1RkaMx1Z1IiGBPWY6iG3ahRDfHqgYuO0rhNX0iZ3/2+sqE7NhmA/B4DvdXfS2Mnfp33eXWQg3e0ycOqgaEA0V8UrenLGy4W9jFHZ2hAb7yqJslO6XQnWWuHlVhJOdif479BCAhzlXIoyML/GFVfhX9j2JrDXxMx47LKyLEinta3Qn12EPdoPJMc0T7VKWNupvfKq2w9pAgMBAAECggEAAPuQe5gOTeLX/uIjGESmPKgUsbbFPsPEAejk0jIhnt/HW6IZWGQQvnf1UyQ/keI7/0LCIStHR2FORngT7U9eZdvnNOJUmALarQ+4EzOORh7K5HaBt2m3fNrOfaU4dv6aJE4V5vqqY7IkrmgQHftfTkPyg8XowWWK0NehzQsJ0mNNgtnyDe0kmWDq8ZcIpAPJfYhDOD9DRgCaiGWqspApZWOUndhcwCx6GG+/vkFzriOc7QKlRTSAU8QP9pvV9cVmnQEIxi0zgS4XDZZct3BBpdgfrusuiJSbe5/iPX42gUbX0YA3LkywgGskFk0wPbJUICsCpH7MSRW2Hba+tDhSlQKBgQDsPxOchfhke1QCvPo38883CNnpcKSCuGFC3udoy1jvMgFbDzYySNbfRxjhHWKaIIqq0WUjtAeIPdHqigJakrBrKEXJed7MrfXcaa66LkITx48iZRr/XoVMKZlb+0xPZWuB6p3zShxw188A+f9Z0EDs1FfXkSuW6oN59yLQKuv8zwKBgQDPFMgdR3IMCTDgxq0nhpbfSJjj1QyS6Gx8XgjvrVUCkXF08qDRw0OwwU3yfBflHUtw28Q2ngUFw/2M+QDStjaVQbiWXEqx92iRsR9uWOXzxRj4GelZRggFdu1VMTQFKGYiCJWi6IpL9KKux/uE7gxBLEOVnX0p26ho+JlMToluRwKBgQCZT63Ia+BwROCWDlFLMjuM+X+A0IrSEhl8Le96wEvsnkTm9Q40v7RBnX/1xv4QC4IxrEW4T8J7lbK+Q+WXJY67W50+TIpbxaDB8wti41YaQ+0NYxOMGajjbjOJz6EL/UMxQjJSigu+5y388j/V5yHbD0oaKKli/Llp0wmSkegnXQKBgF27+W0PZvc9vcsxAzXt/SLquJIAYOWqoViWNBNRcTZtYV7faJ4qddxvU3ocY7CI1xop0CIs2vcmJQIHwDCg3AopqoUdF46A/+tasnB/eu8h21CKYg7P3Vej4n/6eqKPC9QB8MHB4r/I506YJSihnBhwEdOKaxpkXFHPnYxlzF2HAoGALaunJPW97z2jIV/7himiO1lW+ipGekStqJDEokCHVB1xAE/lznQmydzC2cURbBuWlGsCL7GhBuEO64k0gefSLcREdqe5/Mcp5FxQroZrVtG0suQj83ftlDDP9i8ayH1iL9dYop05H3FfeJfW9BRaE+huZHf+OPgzgzDav5hL5pg=";
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encoded = decoder.decode(privateKey);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return keyFactory.generatePrivate(keySpec);
    }

}
