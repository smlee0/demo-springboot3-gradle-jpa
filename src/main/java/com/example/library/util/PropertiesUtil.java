// package com.example.library.util;
//
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.Reader;
// import java.io.UnsupportedEncodingException;
// import java.nio.charset.Charset;
// import java.nio.charset.StandardCharsets;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.List;
// import java.util.Map;
// import java.util.Properties;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Component;
//
// import lombok.RequiredArgsConstructor;
//
// /**
//  * 프로퍼티 유틸
//  * .properties 파일에서 불러올 때 사용 (.yaml에서는 호환되지 않음)
//  *
//  * @author LEESEMIN
//  */
// @Component
// @RequiredArgsConstructor
// public class PropertiesUtil {
// 	private static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);
// 	private static Map<String, String> propertiesCacheMap = new HashMap();
// 	private static Map<String, String> propertiesLoadMap = new HashMap();
// 	private static int propertiesCacheTimeout = 30;
//
// 	public static String get(String keyName) {
// 		return get(keyName, StandardCharsets.UTF_8, System.getProperty("spring.profiles.active"));
// 	}
//
// 	public static String get(String keyName, Charset encodeCharset, String profile) {
// 		ClassPathResource classPathResource = null;
// 		InputStream in = null;
// 		Reader reader = null;
// 		Properties props = null;
//
// 		try {
// 			try {
// 				classPathResource = new ClassPathResource("config/application-" + profile + ".yaml");
// 				String entryKey;
// 				if (classPathResource.exists()) {
// 					in = classPathResource.getInputStream();
// 				}
//
// 				reader = new InputStreamReader(in, encodeCharset);
// 				props = new Properties();
// 				props.load(reader);
// 				entryKey = "";
// 				String entryVal = "";
// 				Iterator var11 = props.entrySet().iterator();
//
// 				while (var11.hasNext()) {
// 					Map.Entry<Object, Object> entry = (Map.Entry)var11.next();
// 					entryKey = String.valueOf(entry.getKey());
// 					entryVal = String.valueOf(entry.getValue());
// 					propertiesCacheMap.put(entryKey, entryVal);
// 				}
//
// 				return replaceSystemVariables(propertiesCacheMap.get(keyName));
// 			} catch (UnsupportedEncodingException var30) {
// 				log.error(var30.getLocalizedMessage());
// 			} catch (IOException var31) {
// 				log.error(var31.getLocalizedMessage());
// 			}
//
// 			return replaceSystemVariables(propertiesCacheMap.get(keyName));
// 		} finally {
// 			if (props != null) {
// 				props = null;
// 			}
//
// 			if (reader != null) {
// 				try {
// 					reader.close();
// 					reader = null;
// 				} catch (IOException var29) {
// 					log.error(var29.getLocalizedMessage());
// 				}
// 			}
//
// 			if (in != null) {
// 				try {
// 					in.close();
// 					in = null;
// 				} catch (IOException var28) {
// 					log.error(var28.getLocalizedMessage());
// 				}
// 			}
//
// 			if (classPathResource != null) {
// 				classPathResource = null;
// 			}
//
// 		}
// 	}
//
// 	private static String replaceSystemVariables(String richText) {
// 		if (richText == null) {
// 			return null;
// 		} else {
// 			Pattern pattern = Pattern.compile("[$][{][{]\\w+[}][}]");
// 			Matcher matcher = pattern.matcher(richText);
// 			List<String> sysVarList = new ArrayList();
//
// 			while (matcher.find()) {
// 				sysVarList.add(matcher.group(0));
// 			}
//
// 			String returnString = richText;
// 			String sysKey = null;
// 			String sysVal = null;
// 			Iterator var7 = sysVarList.iterator();
//
// 			while (var7.hasNext()) {
// 				String sysVar = (String)var7.next();
// 				if (sysVar != null && !"".equals(sysVar)) {
// 					sysKey = sysVar.replaceAll("[${{]", "");
// 					sysKey = sysKey.replaceAll("[}}]", "");
// 					sysVal = System.getenv(sysKey);
// 					returnString = returnString.replaceAll("[$][{][{]" + sysKey + "[}][}]", sysVal);
// 				}
// 			}
//
// 			return returnString;
// 		}
// 	}
//
// }
//
// // private final Environment environment;
// //
// // public String getProperty(String name) {
// // 	return environment.getProperty(name);
// // }