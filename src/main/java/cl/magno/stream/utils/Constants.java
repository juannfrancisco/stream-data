package cl.magno.stream.utils;

import java.io.Serializable;

public final class Constants implements Serializable{

	private Constants(){
		
	}
	
	private static final long serialVersionUID = -6423867806429809281L;
	public static final String SPRING_APP_CONTEXT_PATH_WEB = "/resources/spring/concentrador-app-context.xml";
	public static final String APP_CONTEXT = "com.app";

	public static final String SERVICIO_USUARIO = "servicio-usuario";
	public static final String INICIO = "Inicio";

	public static final String WEBXML_PARAMS_LOG4J = "log4j-path-file";
	public static final String WEBXML_PARAMS_CONFIG = "config-path-file";	
	
	public static final String DISCRIMINATOR_FILE = "FILE";
	public static final String DISCRIMINATOR_DB = 	"DB";
	public static final String DISCRIMINATOR_JMS = 	"JMS";
	public static final String DISCRIMINATOR_WS = 	"WS";
	public static final String DISCRIMINATOR_REST = "REST";
	public static final String DISCRIMINATOR_FTP = 	"FTP";
	
	
	public static final String TIPO_MUESTREADOR_WS = "WS";
	public static final String TIPO_MUESTREADOR_SIMPLE = "SIMPLE";

	public static final String ERROR_SISTEMA = "Error desconocido, intente nuevamente o contactese con el administrador del sistema";
	public static final String MENSAJE_ELIMINACION = "Confirme la eliminacion para el registro ";
	public static final String MSG_FECHA = "Fecha termino debe ser igual o mayor que fecha inicio";
	public static final String EMAIL_INVALIDO = "Email no valido.";
	public static final String RUT_INVALIDO = "Rut no valido.";
	public static final String HORA_INVALIDO = "Hora no valida.";
	public static final String FECHA_INVALIDA = "Fecha no valida.";
	public static final String REQUIRED = "Campo obligatorio";

	public static final String COD_ERROR_SISTEMA = "9999";
	public static final String CODIGO_EXITO = "0";
	public static final String CODIGO_CAMPOS_OBLIGATORIOS= "7";
	public static final String ID_MENU_PADRE = "0";
	public static final String MSG_EXITO_TEST_CONNECTION = "Conexion realizada con exito";
	public static final String MSG_ERROR_TEST_CONNECTION = "Error al probar la Conexion, el driver no esta disponible";
	public static final String MSG_ERROR_TEST_JNDI_NAME = "No se pudo encontrar el recurso para el nombre JNDI";
	public static final String MSG_EXITO_TEST_DIRECTORY = "El directorio fue verificado con exito";	
	public static final String MSG_ERROR_TEST_DIRECTORY = "Error, no es un directorio valido";
	public static final String MSG_ERROR_TEST_CONNECTION_JMS = "Error al probar la Conexion, la cola no esta disponible";
	
	
	public static final String TIPO_EJECUCION_SIMPLE = "MANUAL";
	public static final String TIPO_EJECUCION_LISTENER = "UNICA";
	
	public static final String TIPO_METODO_GET = "GET";
	public static final String TIPO_METODO_POST = "POST";
	
	public static final String MAPPING_SOURCE = "objectSource";
	public static final String MAPPING_TARGET = "objectTarget";
	public static final String CONTEXT_TARGET = "contextTarget";
	public static final String CONTEXT_SOURCE = "contextSource";
	public static final String CONTEXT_MAPPING = "contextMapping";
	public static final String GROUP_QUARTZ = "muestreadores";
	public static final String GROUP_QUARTZ_TRIGGER = "muestreadores";
	public static final String QUARTZ_TRIGGER = "trigger-";
	public static final String PATHCERTIFICADO = "";
	
	public static final String ICON_ESTADO_INICIADO = "flStop.png";
	public static final String ESTADO_INICIADO = "En ejecucion";
	public static final String ICON_ESTADO_PENDIENTE = "flStop.png";
	public static final String ESTADO_PENDIENTE = "Pendiente";
	public static final String ICON_ESTADO_COMPLETADO = "flPlay.png";
	public static final String ESTADO_COMPLETADO = "Completado";
	public static final String ICON_ESTADO_EJECUCION_ERROR = "flStop.png";
	public static final String ESTADO_EJECUCION_ERROR= "Ejecucion con errores";

	
	public static final String TIPO_EJECUCION_CSV = "CSV";
	public static final String TIPO_EJECUCION_INTERFAZ = "INT";
	public static final String TIPO_EJECUCION_STREAM_CSV = "STR";
	public static final String TIPO_EJECUCION_SP_SALIDA = "ejecucionSPsalida";
	public static final String TIPO_EJECUCION_SP_ENTRADA = "ejecucionStoredProcedure";
	
	
	public static final String EMPTY_STRING = "";
	public static final String BEAN_VARIABLES = "variables";
	public static final String BEAN_CONFIG = "configuration";
	public static final String USER_SESSION = "user";
	
	
	public static final String BEAN_NOTIFY_TEMPLATE = "jmsNotifyTemplate";
	public static final String BEAN_EXTRACT_TEMPLATE = "jmsExtractTemplate";
	public static final String BEAN_MAPPING_TEMPLATE = "jmsMappingTemplate";
	public static final String BEAN_NOTIFICATION_TEMPLATE = "jmsNotificationTemplate";
	public static final String PROP_TARGET = "target";
	public static final String PROP_SOURCE = "source";
	public static final String PROP_FLOW = "flow";
	
	
	public static final String CORRELETION_ID_QUEUE_NOTIFY = "notify_stream_data";
	
	public static final String NOTIFY_COMMAND = "NOTIFY_COMMAND";
	public static final String NOTIFY_DATA_FLOW = "NOTIFY_DATA_FLOW";

	
	
}
