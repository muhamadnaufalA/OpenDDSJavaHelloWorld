
// -*- C++ -*-
// Definition for Win32 Export directives.
// This file is generated automatically by generate_export_file.pl HelloWorld
// ------------------------------
#ifndef HELLOWORLD_EXPORT_H
#define HELLOWORLD_EXPORT_H

#include "ace/config-all.h"

#if defined (ACE_AS_STATIC_LIBS) && !defined (HELLOWORLD_HAS_DLL)
#  define HELLOWORLD_HAS_DLL 0
#endif /* ACE_AS_STATIC_LIBS && HELLOWORLD_HAS_DLL */

#if !defined (HELLOWORLD_HAS_DLL)
#  define HELLOWORLD_HAS_DLL 1
#endif /* ! HELLOWORLD_HAS_DLL */

#if defined (HELLOWORLD_HAS_DLL) && (HELLOWORLD_HAS_DLL == 1)
#  if defined (HELLOWORLD_BUILD_DLL)
#    define HelloWorld_Export ACE_Proper_Export_Flag
#    define HELLOWORLD_SINGLETON_DECLARATION(T) ACE_EXPORT_SINGLETON_DECLARATION (T)
#    define HELLOWORLD_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK) ACE_EXPORT_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK)
#  else /* HELLOWORLD_BUILD_DLL */
#    define HelloWorld_Export ACE_Proper_Import_Flag
#    define HELLOWORLD_SINGLETON_DECLARATION(T) ACE_IMPORT_SINGLETON_DECLARATION (T)
#    define HELLOWORLD_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK) ACE_IMPORT_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK)
#  endif /* HELLOWORLD_BUILD_DLL */
#else /* HELLOWORLD_HAS_DLL == 1 */
#  define HelloWorld_Export
#  define HELLOWORLD_SINGLETON_DECLARATION(T)
#  define HELLOWORLD_SINGLETON_DECLARE(SINGLETON_TYPE, CLASS, LOCK)
#endif /* HELLOWORLD_HAS_DLL == 1 */

// Set HELLOWORLD_NTRACE = 0 to turn on library specific tracing even if
// tracing is turned off for ACE.
#if !defined (HELLOWORLD_NTRACE)
#  if (ACE_NTRACE == 1)
#    define HELLOWORLD_NTRACE 1
#  else /* (ACE_NTRACE == 1) */
#    define HELLOWORLD_NTRACE 0
#  endif /* (ACE_NTRACE == 1) */
#endif /* !HELLOWORLD_NTRACE */

#if (HELLOWORLD_NTRACE == 1)
#  define HELLOWORLD_TRACE(X)
#else /* (HELLOWORLD_NTRACE == 1) */
#  if !defined (ACE_HAS_TRACE)
#    define ACE_HAS_TRACE
#  endif /* ACE_HAS_TRACE */
#  define HELLOWORLD_TRACE(X) ACE_TRACE_IMPL(X)
#  include "ace/Trace.h"
#endif /* (HELLOWORLD_NTRACE == 1) */

#endif /* HELLOWORLD_EXPORT_H */

// End of auto generated file.
